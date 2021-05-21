<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<h1>디테일 페이지</h1>
	<div>${param.iboard }</div>
	<div>
		<a href="list">리스트로 돌아가기</a>
	</div>
	<h1 id="title"></h1>
	
	<div>글 번호: <span id = "iboard"></span></div>
	<div>작성자:<span id="unm"></span></div>
	<div>작성일:<span id="regdt"></span></div>
	<div><span id="ctnt"></span></div>

	<script>
	function ajax(iboard){
		console.log('iboard:'+iboard);	
		
		const param = {iboard}
		const init = { method : 'POST' 
				body : new URLSearchParams(param)}
		
		fetch('/board/detail',init)
		.then(function(res){
			return res.json();
		})
		.then(function(myJson){
			console.log(myJson);
			setData(myJson);
		});
	}
	
	function setData(data){
		var iboardElem = decoument.querySelector('#iboard');
		var titleElem = document.querySelector("#title")
		var ctntElem = document.querySelector("#ctnt")
		var regdtElem = document.querySelector("#regdt")
		
		iboardElem.innerText = data.iboard;
		titleElem.innerTxt = data.title;
		ctntElem.innerTxt = data.ctnt;
		regdtElem.innerTxt = data.regdt;
	}	
	
	
	ajax(${param.iboard});
	</script>