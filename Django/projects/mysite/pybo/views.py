from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
from .models import Question

def index(request):
    # pybo 목록 출력
    question_list = Question.objects.order_by('-create_date')   # 내림차순 정렬
    context = {'question_list':question_list}
    return render(request,'pybo/question_list.html', context)
    # return HttpResponse("환영합니다.")


