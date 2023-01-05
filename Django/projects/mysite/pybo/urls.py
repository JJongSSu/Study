from django.urls import path

from . import views

# 네임스페이스 추가
app_name = 'pybo'

urlpatterns = [
    path('',views.index, name='index'),
    path('<int:question_id>/', views.detail, name='detail'), # question_id가 정수이기 때문에 int로 작성
]