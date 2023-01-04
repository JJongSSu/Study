from django.db import models

# Create your models here.
class Question(models.Model):
    subject = models.CharField(max_length=200,verbose_name='질문의 제목')
    # CharField = input() 역할
    content = models.TextField(verbose_name='질문의 내용')
    create_date = models.DateTimeField()
    
    def __str__(self):
        return self.subject
    
class Answer(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    # CASCADE : 연쇄적으로 반응
    # on_delete=models.CASCADE : ForeignKey인 Question을 삭제할 시 답변들도 삭제 
    # on_delete=models.PROTECT : 자식쪽의 데이터가 있을 경우 부모쪽의 데이터가 삭제되지 않게 보호
    content = models.TextField(verbose_name='답변 내용')
    create_date = models.DateTimeField()
    def __str__(self):
        return self.content
