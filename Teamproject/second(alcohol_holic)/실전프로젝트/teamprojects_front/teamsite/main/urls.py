from django.urls import path
from django.contrib.auth import views as auth_views
from . import views
from django.conf.urls import include

app_name = 'main'

urlpatterns = [
    path('index', views.index, name='index'),
    path('info', views.info, name='info'),
    path('buy', views.buy, name='buy'),
    path('sub', views.sub, name='sub'),
    path('prod', views.prod, name='prod'),
    path('buy2', views.buy2, name='buy2'),
    path('', views.index, name='index'),
]

