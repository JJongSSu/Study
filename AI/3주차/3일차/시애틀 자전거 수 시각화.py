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
