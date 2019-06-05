$(document).ready(function() {
	var $campo = $("#inputCEP");
	$campo.mask('00000-000', {reverse : true});
});

$(document).ready(function() {
	var $campo = $("#inputCPF");
	$campo.mask('000.000.000-00', {reverse : true});
});

function apenasNumerosOuX(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode != 8) { 
		if (unicode < 48 || unicode > 57){
			if (unicode != 88 && unicode != 120){
				return false
			}
		} 
	}
}

function apenasNumeros(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode != 8) { //se a key não for o backspace
		if (unicode < 48 || unicode > 57) //se não for um número
			return false //desabilita o keypress -> cancela a inserção do caracter digitado
	}
}