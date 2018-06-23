# _*_ coding: utf-8 _*_

'''
2018.6.22 多线程爬取斗图网站

'''

import requests
import threading # 多线程处理与控制
from bs4 import BeautifulSoup
from lxml import etree # 解析网页,比自带的html.parser速度更快

# 获取一个网页的源码
# url地址是指每一页的地址，等会用format函数传递页码，实现多页爬取
def get_html(url):
    # url = 'https://www.doutula.com/article/list/?page=1'
    headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36"}
    request = requests.get(url=url, headers=headers)
    response = request.text
    return response
# print(get_html(''))

# 获取每一页的所有套图的链接，利用套图链接去获取所有套图详情网页源码（有点绕）
def get_img_html(html):
    soup = BeautifulSoup(html, 'lxml')  # 创建一个对象
    # 每一页中所有套图链接
    all_a = soup.find_all('a', class_='list-group-item random_list tg-article')
    # print(all_a)
    for link in all_a:
        # 获取每个套图详情的网页源码
        # print(link)
        hrefAttr = link['href']
        img_html = get_html(link['href'])
        # 最后将一页中10个套图详情的源码拼接
        img_html += img_html
        # print(img_html)
        return img_html
# html = get_html('https://www.doutula.com/article/list/?page=1')
# print(get_img_html(html))

# 利用xpath获取每一个图片的带有src地址的onerror属性内容
# 获取每个图片src地址
def get_img(html):
    soup = etree.HTML(html) # 初始化打印源码,自动修正html源码
    # //代表选择盒子内容,[]代表过滤的条件 @选定属性盒子
    items = soup.xpath('//div[@class="artile_des"]')    # 解析网页方法
    for item in items:
        imgurl_list = item.xpath('table/tbody/tr/td/a/img/@onerror')
        start_save_img(imgurl_list)

# 利用正则获取onerror内容里的图片src地址，然后用多线程实现下载图片
# 下载图片
def save_img(img_url):
    # img_url = img_url.split('=')[-1][1:-1].replace('jp','jpg')
    img_url = img_url.split('=')[-1][1:-1]
    print(u'正在下载'+'http:'+img_url)
    img_content = requests.get('http:'+img_url).content
    # with open('C:\\Users\\ZQXye\\Desktop\\doutu\\%s.jpg'
    #           % img_url.split('/')[-1], 'wb') as f:
    #     f.write(img_content)
    with open('C:\\Users\\ZQXye\\Desktop\\doutu\\%s'
              % img_url.split('/')[-1], 'wb') as f:
        f.write(img_content)
# 多线程
def start_save_img(imgurl_list):
    for i in imgurl_list:
        th = threading.Thread(target=save_img, args=(i,))
        th.start()  # 启动线程

# 调用方法执行
# 多页
def main():
    start_url = 'https://www.doutula.com/article/list/?page={}'
    # print(start_url.format(1))
    for i in range(1, 7):
        start_html = get_html(start_url.format(i))  # 获取外页url
        html = get_img_html(start_html) # 获取内页url里面的源码
        get_img(html)
main()
print("爬取结束")
# img_url = "this.src='//img.doutula.com/production/uploads/image/2018/06/21/20180621549183_YcujZH.gif'"
# img_url = img_url.split('=')[-1][1:-2].replace('jp','jpg')
# print(img_url)
# print(img_url.split('='))
# print(img_url.split('=')[-1])
# print(img_url.split('=')[-1][1:-1])