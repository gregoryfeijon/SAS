window.addEventListener("load", function () {
	
	const $cep = document.querySelector('[name="endereco.cep"]');
	const $cpf = document.querySelector('[name="cpf"]');
	
	$cep.addEventListener("blur", infosDoEvento => {
		const $cepTarget = infosDoEvento.target.value;
		$cepTarget.mask('00000-000', { reverse : true });
	})
	
	$cpf.addEventListener("blur", infosDoEvento => {
		const $cpfTarget = infosDoEvento.target.value;
		$cpfTarget.mask('000.000.000-00', { reverse : true });
	})
});

function apenasNumerosOuX(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode != 8) {
		if (unicode < 48 || unicode > 57) {
			if (unicode != 88 && unicode != 120) {
				return false
			}
		}
	}
}

function apenasNumerosComVirgula(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode != 8 && (unicode != 44 || unicode != 46)) {
		if (unicode < 48 || unicode > 57)
			return false
	}
}

function apenasNumeros(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode != 8) { // se a key não for o backspace
		if (unicode < 48 || unicode > 57) // se não for um número
			return false // desabilita o keypress -> cancela a inserção do
							// caracter digitado
	}
}

$(".validaLetras").on("input", function(){
	  var regexp = /[^a-zA-Z\u00C0-\u00FF ]/g;
	  if(this.value.match(regexp)){
	    $(this).val(this.value.replace(regexp,''));
	  }
});