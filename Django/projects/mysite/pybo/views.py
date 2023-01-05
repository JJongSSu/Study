from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.http import HttpResponse
from .models import Question

def index(request):
    # pybo 목록 출력
    question_list = Question.objects.order_by('-create_date')   # 내림차순 정렬
    context = {'question_list':question_list}
    return render(request,'pybo/question_list.html', context)
    # return HttpResponse("환영합니다.")

def detail(request, question_id):
    # pybo 내용 출력
    # question = Question.objects.get(id=question_id)
    question = get_object_or_404(Question, pk=question_id)  # 있는 건 보여주고 없으면 오류 페이지 보여줌
    context = {'question':question}
    return render(request, 'pybo/question_detail.html', context)


