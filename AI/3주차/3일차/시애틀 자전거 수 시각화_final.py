# https://data.seattle.gov/api/views/65db-xm6k/rows.csv?accessType=DOWNLOAD
import matplotlib
import matplotlib.pyplot as plt
#FremontBridge.csv--> goo.gl/o3FkTM
import  numpy as np
import  pandas as pd
from docutils.nodes import inline

data=pd.read_csv("FremontBridge - 복사본.csv",index_col='Date',parse_dates=True)

print(data.head(5))

#열이름을 단축하고 total 추가
data.columns=['West','East']
data['Total']=data.eval('West+East')
data.head(5)

#요약통계
data.describe()

import seaborn
seaborn.set()
plt.show()

data.plot()
plt.ylabel('Hourly Bicyle Count');
plt.show()

#25000개의 시간별 표번 이해하기어려움
#데이터를 주 단위로 리 샘플링
weekly=data.resample('W').sum()
weekly.plot(style=[':','--','-'])
plt.ylabel('Weekly bicycle count')
plt.show()

#겨울보다 여름에 자전거를 더 많이 타며
#특정 계절에는 자전거 사용횟수가 주마다 달라진다.

#30일 이동평균(rolling)
daily=data.resample('D').sum()
daily.rolling(30,center=True).sum().plot(style=[':','--','-'])
plt.ylabel('mean hourly count')

#가우스 평활(Gaussian smoothing)적용
#가우스 윈도우(Gussian window)같은 윈도우 함수를 사용해 롤링 평균을 부드럽게 표현
#윈도우 폭(50일)윈도우내 가우스 폭(10) 지정

daily.rolling(50,center=True,
              win_type='gaussian').sum(std=10).plot(style=[':','--','-'])
plt.show()

#하루의 시간대를 기준으로 한 함수로 평균 통행량을 보고 싶을때
by_time=data.groupby(data.index.time).mean()
hourly_ticks=4*60*60*np.arange(6)
by_time.plot(xticks=hourly_ticks,style=[':','--','-'])
plt.show()

#아침 8시,저녁5시 무렵에 많이 사용
#동서가 확연하게 나누어짐.. 출근 사용량

#요일별 통행량?
by_weekday=data.groupby(data.index.dayofweek).mean()
by_weekday.index=['Mon','Tues','Wed','Thurs','Fri','Sat','Sun']
by_weekday.plot(style=[':','--','-'])
plt.show()


#주중에 많고.. 주말에 적음.. 출퇴근용 가능성..

#주중과 주말의 시간대별 추이
#데이터를 주말을 표시하는 플래그와 시간대별로 분류

weekend=np.where(data.index.weekday <5,'Weekday','Weekend')
by_time=data.groupby([weekend,data.index.time]).mean()

#다중 서브플롯
fgs,ax=plt.subplots(1,2,figsize=(14,5))
by_time.loc['Weekday'].plot(ax=ax[0], title='Weekdays',
                           xticks=hourly_ticks,style=[':','--','-'])
by_time.loc['Weekend'].plot(ax=ax[1], title='Weekends',
                           xticks=hourly_ticks,style=[':','--','-'])

plt.show()

#주중에서 양봉 형태.. 주말에는 낮시간에 피크..
# 출퇴근 패턴에 영향을 미치는 날씨와 온도, 연중 시기 등 기타 요인 분석이 필요

#Is settle really Seeing an Uptick in Cycling?

#(시애틀의 자전거 통행향 예측)

#미 기상청의 데이터세트와 연결
#선형 회귀를 사용해 날씨와 다른 정보를 자전거 수와 관련짓고
# 이 가운데 한 가지 모수의 변화가 해당 일자에 자전거를 탄 사람의 수에 어떻게 영향을 주는지 추정

#데이터를 적재하고 날짜를 인덱스로 지정
#FremontBridge.csv-->goo.gl/o3FkTM
#BicycleWeather.csv-->goo.gl/7ncbCd

import  pandas as pd
counts=pd.read_csv('FremontBridge - 복사본.csv',index_col='Date',parse_dates=True)
weather=pd.read_csv('BicycleWeather - 복사본.csv',index_col='DATE',parse_dates=True)

print(counts.head(3))

print(weather.head(3))

#일별 총 자전거 통행량을 계산해서 별도의 DataFrame에 넣음
daily=counts.resample('d').sum()
daily['Total']=daily.sum(axis=1)
daily=daily[['Total']]  #다른열 삭제

print(daily.head(3))

#요일을 나타내는 열 추가
days=['Mon','Tue','Wed','Thu','Fri','Sat','Sun']
for i in range(7):
    daily[days[i]]=(daily.index.dayofweek==i).astype(float)

print(daily.head(3))

#휴일에 자전거를 타는 사람
from pandas.tseries.holiday import USFederalHolidayCalendar
cal=USFederalHolidayCalendar()
holidays=cal.holidays('2012','2016')
daily=daily.join(pd.Series(1,index=holidays,name='holiday'))
daily['holiday'].fillna(0,inplace=True)

print(daily.head(3))

#일조시간에 자전거를 타는 사람
from datetime import datetime
def hours_of_daylight(date,axis=23.44, latitude=47.61):
    #해당 날짜의 일조시간 계산
    days=(date - datetime(2000, 12, 21)).days
    m=(1.-np.tan(np.radians(latitude)) * np.tan(np.radians(axis)*np.cos(days*2*np.pi/365.25)))
    return 24 * np.degrees(np.arccos(1-np.clip(m,0,2)))/180.

daily['daylight_hrs']=list(map(hours_of_daylight,daily.index))
daily[['daylight_hrs']].plot()
plt.ylim(8,17)
plt.show()

#데이터에 평균 기온과 전체 강수량 추가
#인치 단위의 강수량과 더불어 날이 건조 했는지(강수량이 0) 알려주는 플래그 추가
#기온은 섭씨 1/10도 단위, 섭씨 1도 단위로 변환

weather['TMIN']/=10
weather['TMAX']/=10
weather['Temp(c)']=0.5 *(weather['TMIN']+weather['TMAX'])

#강수량은1/10mm단위: 인치 단위로 변환

weather['PRCP']/=254
weather['dry day']=(weather['PRCP']==0).astype(int)

daily=daily.join(weather[['PRCP','Temp(c)','dry day']])

print(daily.head(4))

#첫날부터 증가하는 계수기를 추가해 몇해가 지났는지를 측정
#관측된 일별 통행향이 연도별로 증가하거나 감소하는지를 측정

daily['annual']=(daily.index-daily.index[0]).days/365

print(daily.head(5))

#요일 플래그는 해당 요일에 특화된 절편으로 동작하기 때문에fit_intercept=False로설정

#널값 행은 제거
daily.dropna(axis=0,how='any',inplace=True)

columns_names=['Mon','Tue','Wed','Thu','Fri','Sat','Sun',
               'holiday','daylight_hrs','PRCP','dry day','Temp(c)','annual']
X=daily[columns_names]
y=daily['Total']

X.head(3)

from sklearn.linear_model import LinearRegression

model=LinearRegression(fit_intercept=False)
model.fit(X,y)

daily['predicted']=model.predict(X)

#총 자전거 통행량과 예상 자전거 통행향 비교

daily[['Total','predicted']].plot(alpha=0.5)

plt.show()

#여름에 차이가 많이 남
#고려한 요인 외
#사람들이 일하러 갈때 자전거를 탈지 경정하는데 영향을 주는 요인은 뭐가 있을까?
#미처 고려하지 못한 비서형 관계
#사람들이 기온이 높거나 낮을때 자전거를 덜 탈수도 있다.

#각특징이 요일별 자전거 통행량에 얼마나 기여하는지 추정하는 선형모델계수

params=pd.Series(model.coef_,index=X.columns)
print(params)

#불확실성에 대한 척도 없이는 해석이 어려움
#데이터의 부트스트랩 표본 재추출(bootstrap resampling)을 사용하여 불확실성을 계산

from sklearn. utils import resample
np.random.seed(1)
err=np.std([model.fit(*resample(X,y)).coef_
                      for i in range(1000)],0)

#추정된 오차를 가지고 결과를
print(pd.DataFrame({'effect':params.round(0),'error':err.round(0)}))

# 주단위로 비교적 안정적인 추세
# 주말과 휴일보다 주중에 자전거를 타는 사람이 훨씬 많다.
# 일조시간이 1시간 늘어날때마다 129+-9명이 더 자전거를 탄다.
# 기온이 섭씨 1도씩 증가할 때마다 65+-4명의 사람이 더 자전거를 잡는다.
# 맑은날은 평균 548+_33명이 더 자전거를 탄다.
# 강수량이 1인치 늘어날때마다 665+-62명의 사람이 자전거를 집에 두고 나온다.
# 매년 일별 자전거 사용자가 27+-18명씩 완만하게 증가하고 있다.


# 이 모델이 몇가지 관련 정보를 누락하고 있음.
## -.비 선형 효과(예. 강수량과 추운 기온의 영향),
## -.각 변수 내의 비선형 추세(예. 매우 춥거나 매우 더운 온도에서 자전거 통행량의 감소)
# 는 이 모델로 설명할 수 없음.
# 몇 가지 세부적인 정보는 고려하지 않았음.
## -. 아침에 비가 오는 것과 오후에 비가 오는 것의 차이
## -. 요일간의 상관 관계




