function isNull(obj, msg) {
	if(obj.value == "") {
		if(msg) {
			alert(msg);
		}
		obj.focus();
		return true;
	}
	return false;
}

function isNumber(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	for(var i=0; i < str.length; i++) {
		if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
			return false;
	}
	return true;
}

function isSame(obj1, obj2) {
	var str1 = obj1.value;
	var str2 = obj2.value;
	if(str1.length == 0 || str2.length == 0)
		return false;

	if(str1 == str2)
		return true;
	return false;
}

function isShort(obj, len, msg) {
	var str = obj.value;
	if(str.length < len) {
		if(msg) {
			alert(msg);	
		}
		obj.focus();
		obj.select();
		return true;
	}
	return false;
}

function isAlphabet(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	for(var i=0; i < str.length; i++) {
		if(!('A' <= str.charAt(i) && str.charAt(i) <= 'Z'))
			return false;
	}
	return true;
}

function isAlphaNumeric(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	for(var i=0; i < str.length; i++) {
		if(!(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') ||
			('0' <= str.charAt(i) && str.charAt(i) <= '9')))
			return false;
	}
	return true;
}

function isID(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	if(!('A' <= str.charAt(0) && str.charAt(0) <= 'Z'))
		return false;

	for(var i=1; i < str.length; i++) {
		if(!(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') ||
			('0' <= str.charAt(i) && str.charAt(i) <= '9') ||
			(str.charAt(i) == '_')))
			return false;
	}
	return true;
}

function isEmail(obj) {
	var str = obj.value;
	if(str == "")
		return false;

	var i = str.indexOf("@");
	if(i < 0)
		return false;

	i = str.indexOf(".");
	if(i < 0)
		return false;
	
	return true;
}

function isCardNumber(obj) {
	var str = obj.value;
	if(str.length != 16)
		return false;

	for(var i=0; i < 16; i++) {
		if(!('0' <= str.charAt(i) && str.charAt(i) <= '9')) 
			return false;
	}
	return true;
}

function isSSN(front, back) {
	var birthday = front.value;
	var num = back.value;

	if(birthday.length != 6) {
		return false;
	}
	if(num.length != 7) {
		return false;
	}
	var hap = 0;
	for(var i=0; i < 6; i++) {
		var temp = birthday.charAt(i) * (i+2);
		hap += temp;
	}

	var n1 = num.charAt(0);
	var n2 = num.charAt(1);
	var n3 = num.charAt(2);
	var n4 = num.charAt(3);
	var n5 = num.charAt(4);
	var n6 = num.charAt(5);
	var n7 = num.charAt(6);

	hap += n1*8+n2*9+n3*2+n4*3+n5*4+n6*5;
	hap %= 11;
	hap = 11 - hap;
	hap %= 10;
	if(hap != n7)
		return false;
	return true;
}

