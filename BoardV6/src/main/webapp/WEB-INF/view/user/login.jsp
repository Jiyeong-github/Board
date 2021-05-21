<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>${errMSG}</div>
<div>
	<a href="join">회원가입</a>
</div>
<div>
	<form id="frm">
		<div>
			<input type="text" name="uid" placeholder="id">
		</div>
		<!-- input은 자식이 있을 수 없음 -->
		<div>
			<input type="password" name="upw" placeholder="password">
		</div>
		<div>
			<input type="submit" value="login">
		</div>
	</form>

	<input type="button" value="회원가입" onclick="join();">
	<div>
		<a href="join"></a>
	</div>

</div>
