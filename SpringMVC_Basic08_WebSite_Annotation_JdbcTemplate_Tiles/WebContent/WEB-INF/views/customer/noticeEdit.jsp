<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항수정
						</li>
					</ul>
					<form action="" method="post" enctype="multipart/form-data">
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목 
							</dt>
							<dd class="article-detail-data">
								&nbsp; <input name="title" value="${notice.title}"/>
							</dd>
						</dl>	
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								${notice.writer}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								${notice.hit}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일1
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input type="file" id="txtFile1" name="files[0]" />
								<%-- ${notice.fileSrc} --%>
							</dd>
						</dl>
						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일2
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input type="file" id="txtFile2" name="files[1]" />
								<%-- ${notice.fileSrc} --%>
							</dd>
						</dl>
						
						<div class="article-content" >
							<textarea id="txtContent" class="txtContent" name="content">
							${notice.content}
							</textarea>
						</div>						
					</div>
					<p class="article-comment margin-small">
						<input class="btn-save button" type="submit" value="수정"></input>
						<a class="btn-cancel button" href="noticeDetail.htm?seq=${notice.seq}">취소</a>						
					</p>		
					</form>					
				</div>	