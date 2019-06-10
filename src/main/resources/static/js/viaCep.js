//$(document).ready(function() {
window.addEventListener("load", function () {

	const $cep = document.querySelector('[name="endereco.cep"]');
	const $cidade = document.querySelector('[name="endereco.cidade"]');
	const $bairro = document.querySelector('[name="endereco.bairro"]');
	const $rua = document.querySelector('[name="endereco.rua"]');
	const $estado = document.querySelector('[id="opEstado"]');
	
	//endereco.bairro
	
	$cep.addEventListener("blur", infosDoEvento => {
		const cepTarget = infosDoEvento.target.value;
		fetch(`https://viacep.com.br/ws/${cepTarget}/json/`)
		.then(respostaDoServer => {
			return respostaDoServer.json();
		}).then(dadosDoCep => {
			console.log(dadosDoCep);
			$cidade.value = dadosDoCep.localidade;
			$bairro.value = dadosDoCep.bairro;
			$rua.value = dadosDoCep.logradouro;
			$estado.innerHTML = dadosDoCep.uf;
		})
	})

});
