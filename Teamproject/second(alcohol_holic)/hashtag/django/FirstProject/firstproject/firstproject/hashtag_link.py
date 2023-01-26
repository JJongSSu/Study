from django import template

register = template.Library()

@register.filter
def hashtag_check(article):
    '''
    article의 content를 파싱해서 #으로 시작하는 단어들을 
    a태그로 감싸줍니다. 
    ex) {{ article|hashtag_check }}
    '''
    content = article.content
    hashtags = article.hashtags.all() # #디장고 #오늘

    for hashtag in hashtags:
        # #디장고 => <a href="">#디장고 </a>
        content = content.replace(
            hashtag.content,
            f'<a href="/articles/{hashtag.pk}/hashtag/">{hashtag.content}</a>'
        )

    return content