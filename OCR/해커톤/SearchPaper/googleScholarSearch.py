# 설치 먼저 진행해주세요!!!
# pip install scrape-google-scholar-py

from google_scholar_py import CustomGoogleScholarProfiles
import json

# keyword 부분에 원하는 단어 입력
# 원하는 키워드의 저자 프로필
def searchScholarProfiles(keyword):
    parser = CustomGoogleScholarProfiles()
    data = parser.scrape_google_scholar_profiles(
        query=keyword,
        pagination=False,
        save_to_csv=False,
        save_to_json=False
    )
    
    paperData = json.dumps(data, indent=2)
    print(paperData)
    
    return paperData

# 원하는 키워드의 기본적인 논문
def searchScholarOrganic(keyword):
    parser = CustomGoogleScholarProfiles()
    data = parser.scrape_google_scholar_profiles(
        query=keyword,
        pagination=False,
        save_to_csv=False,
        save_to_json=False
    )
    
    paperData = json.dumps(data, indent=2)
    print(paperData)
    
    return paperData

# 유명한 기사들
def searchScholarTopPublicationArticle(keyword):
    parser = CustomGoogleScholarProfiles()
    data = parser.scrape_google_scholar_profiles(
        query=keyword,
        pagination=False,
        save_to_csv=False,
        save_to_json=False
    )
    
    paperData = json.dumps(data, indent=2)
    print(paperData)
    
    return paperData

if __name__ == "__main__":
    print(searchScholarOrganic('label:computer_vision "Michigan State University"|"U.Michigan"'))

