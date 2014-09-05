$(document).ready(function () {
    $('#data-nascimento').mask('00/00/0000');
    /*$('.time').mask('00:00:00');
    $('.date_time').mask('00/00/0000 00:00:00');*/
    $('#cep').mask('00000-000');
    /*$('#telefone').mask('0000-0000');*/
    $('#telefone').mask('(00) 0000-0000');
    /*$('.phone_us').mask('(000) 000-0000');
    $('.mixed').mask('AAA 000-S0S');*/
    $('#cpf').mask('000.000.000-00', { reverse: true });
    /*$('.money').mask('000.000.000.000.000,00', { reverse: true });*/
});

//var form = $("#formulario");
var form = document.getElementById("formulario");
var botao = form.querySelector("button");
var idade = document.getElementById("idade");

//var senha = $("#senha");
//var confirmaSenha = $("#confirma-senha");

var senha = document.getElementById("senha");
var confirmaSenha = document.getElementById("confirma-senha");

function checaSenha() {
    var senhasIguais = senha.value === confirmaSenha.value;

    if (senhasIguais) {
        confirmaSenha.setCustomValidity("");
        //O método setCustomValidity pode ser invocado por você. Ele recebe uma string. Se a string for vazia, o campo será marcado como válido. 
        //Caso contrário, será marcado como inválido.
    }
    else {
        confirmaSenha.setCustomValidity("As senhas não coincidem");
    }
}

function addSenhasInputEventListeners() {
    senha.addEventListener("input", checaSenha, false);
    confirmaSenha.addEventListener("input", checaSenha, false);
    idade.addEventListener("input", verificaIdade, false );
}

function submeteFormulario() {
    form.classList.add("submete_formulario");
}

function addSubmenteFormularioEventListerner() {
    botao.addEventListener("click", submeteFormulario, false);
}

// Verifica Idade

function verificaIdade() {

    var valorIdade = parseInt(idade.value);

    if (valorIdade >= 18) {
        idade.setCustomValidity("");      
    }
    else {
        idade.setCustomValidity("Menor de Idade , precisa ser maior de idade");
    }
}

addSenhasInputEventListeners();
addSubmenteFormularioEventListerner();