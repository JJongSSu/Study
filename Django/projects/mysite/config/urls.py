"""config URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
# 추가
from pybo import views

urlpatterns = [
    path('admin/', admin.site.urls),
    # 추가
    # localhost:8000/pybo/ URL과 views.index() 함수를 매핑
    # 장고는 URL과 뷰 함수를 매핑
    # path('pybo/', views.index),
    # include(module)
    path('pybo/', include('pybo.urls')),
]
