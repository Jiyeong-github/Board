function delCmt(iboard, icmt) {
	console.log(`iboard:${iboard},icmt:${icmt}`);
	//javascript 문법임 `\${}` - > EL식이 아니라 그대로 찍어달라는 뜻
	if (confirm('삭제하시겠습니까?')) { //confirm 메소드임 - ()이거 리턴 있는 놈
		location.href = `/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}