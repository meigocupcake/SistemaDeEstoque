document.addEentListener("DOMContentLoaded", function(){
const campoCep = document.getElementById("cep");

campoCep.addEventListener("blur", buscarCEP);
campoCep.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        buscarCEP();
    }
    });    
});

async function buscarCEP(){
    const campoCEP = document.getElementById("cep");
    
    const cep = campoCep.value.replace(/\D/g, "");
    
    if(cep.length !== 8){
        if(cep.length > 0){
            alert("O seu CEP está incorreto.");
            limparCampoEndereco();
        }
        return;
    }
    campoCep.style.botderColor = '#aaa';
    preencherCampos({aguardando: true});
    
    try{
        const response = await fetch('viacep.com.br/ws/{cep}/json/')
        const dados = await response.json();
        
        if (dados.erro){
            alert("CEP não encontrado.");
            limparCampoEndereco();
            campo.Cep.style.borderColor = "red";
            return
        }
        
        preencherCampos(dados);
        campoCep.style.bordercolor = "green";
        
        campoCep.value = cep.replace(/(\d{5})(\d{3})/, "$1-$2");
        
        document.getElementById("numero");
    } catch(error){
        alert("Verifique a conexão com a internet");
        limparCampoEndereco();
        campo.Cep.style.borderColor = "red";
        console.error('Erro na busca do CEP: ', error);
        
    }
}