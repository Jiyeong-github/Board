var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');
var cmtModModalElem = document.querySelector('#modal');

function regCmt() {

	var cmtVal = cmtFrmElem.cmt.value;
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};
	regAjax(param);
}

//서버에 등록
function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};

	fetch('cmtInsSel', init) //cmtinssel 이거 어디서 나온 거임?
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);

			switch (myJson.result) {
				case 0:
					alert('등록 실패');
					break;
				case 1:
					cmtFrmElem.cmt.value = '';
					getListAjax();
					break;
			}
		});
}

//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;

	fetch('cmtInsSel?iboard=' + iboard)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson)

			makeCmtElemList(myJson);
		});
}

function makeCmtElementList(data) {

	cmtListElem.innerHTML = '';
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRedgt = document.createElement('th');
	var thElemBigo = document.createElement('th');
	//append만 써도 ㄱㅊ 유연함

	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRedgt.innerText = '작성일';
	thElemBigo.innerText = '비고';

	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdt);
	trElemTitle.append(thElemBigo);

	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);

	var loginUserPk = cmtListElem.dataset.login_user_pk;

	data.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');

		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdt);

		if (parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			//자스가 동작 안 하는 거 같을 때 F12>sources>디버깅 시 파란색 포인트

			delBtn.addEventListener('click', function() {
				//''앞에 어떤 이벤트였는 지 적어주기, function() 함수
				if (confirm('삭제하시겠습니까?')) {
					delAjax(item.icmt);
				}
			});

			modBtn.addEventListener('click', function() {
				//댓글 수정 모달창 띄우기
				openModModal(item);
			});

			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';

			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}

		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);

		tableElem.append(trElemCtnt);
	})//콜백함수를 보내는 것
}

function delAjax(icmt) {
	fetch('cmtDelUpd?icmt=' + icmt)
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {//"{result:0}"
			console.log(data);

			switch (data.result) {
				case 0:
					alert('댓글 삭제 실패');
					break;
				case 1:
					getListAjax();
					break;
			}
		});
}
function modAjax(){
	var cmtModFrmElem = document.querySelector('#cmtModFrm');
	var param = {
		icmt : cmtModFrmElem.icmt.value,
		cmt : cmtModFrmElem.cmt.value
	}
	
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};

	fetch('cmtDelUpd', init) //cmtinssel 이거 어디서 나온 거임?
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			
			});
}

function openModModal({icmt,cmt}) {
	cmtModModalElem.className = '';
	var cmtModFrmElem = document.querySelector('#cmtModFrm');
	console.log('icmt:'+icmt);
	console.log('cmt:'+cmt);
	
	cmtModFrmElem.icmt.value = icmt;
	cmtModFrmElem.cmt.value = cmt;
}

function closeModModal() {
	cmtModModalElem.className = 'displayNone';
}

getListAjax(); // 이 파일이 임포트되면 함수 1회 호출


