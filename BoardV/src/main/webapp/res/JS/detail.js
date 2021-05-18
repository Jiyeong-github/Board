var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

//삭제
function delCmt(iboard, icmt) {
	console.log(`iboard:${iboard},icmt:${icmt}`);
	//javascript 문법임 `\${}` - > EL식이 아니라 그대로 찍어달라는 뜻
	if (confirm('삭제하시겠습니까?')) { //confirm 메소드임 - ()이거 리턴 있는 놈
		location.href = `regCmt?icmt=${icmt}&iboard=${iboard}`;
	}
	//if문 안에 들어갈 수 있는 타입 : boolean 리턴
}

//수정
function updCmt(icmt, cmt) {
	console.log('icmt:%d', icmt);
	console.log('cmt:%s', cmt);
	updFrm.icmt.value = icmt;
	updFrm.regCmt.value = cmt;
	//이름 맞추기 젭알젭알.. regCmt 젭알.. 
	insFrm.className = 'hidden';
	updFrm.className = '';
}

function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}