const math = require('mathjs') // npmjs.com/package/mathjs
const prompt = require('prompt'); // npmjs.com/package/prompts
const http = require('http'); // nodejs.org/api/http.html

const hostname = '127.0.0.1';
const port = 3000;

prompt.start();

function onErr(err) {
    console.log(err);
    return 1;
}

const ligacao = (valor, num) => {
    return math.evaluate(`${valor} * ${num}`)
}

const estadia = (valor, diarias) => {
    return math.evaluate(`${valor} * ${diarias}`)
}

const refeicao = (valor, num) => {
    return math.evaluate(`${valor} * ${num}`)
}

const imposto = 1.05

var valorTotal = ''

prompt.get(['valorLigacao', 'numLigacoes', 'valorEstadia', 'diarias', 'valorRefeicoes', 'numRefeicoes'], function (err, result) {
    if (err) { return onErr(err); }
    console.log('Input');
    console.log('  Valor da ligação: ' + result.valorLigacao);
    console.log('  Número de ligações: ' + result.numLigacoes);
    console.log('  Valor da estadia: ' + result.valorEstadia);
    console.log('  Diárias: ' + result.diarias);
    console.log('  Valor da refeição: ' + result.valorRefeicoes);
    console.log('  Número de refeições: ' + result.numRefeicoes);

    valorTotal = math.evaluate(`(${ligacao(result.valorLigacao, result.numLigacoes)} + ${estadia(result.valorEstadia, result.diarias)} + ${refeicao(result.valorRefeicoes, result.numRefeicoes)}) * ${imposto}`)

    if(valorTotal){
        const server = http.createServer((req, res) => {
            res.statusCode = 200;
            res.setHeader('Content-Type', 'text/plain');
            res.end('VALOR: ' + valorTotal);
        });
        
        server.listen(port, hostname, () => {
            console.log(`Server running at http://${hostname}:${port}/`);
          });
    }

});

/* Elaborar um componente reutilizavel da seguinte problematica:

Carol Stefany ficou duas noites no West Country Vista Hotel. 
O valor da estadia era de R$125 por noite. 
Carol fez uma ligação telefonica que custou R$ 4,50 e pediu uma refeição no apartamento por R$ 66,00. 
As contas de hotel incluem um imposto estadual de 5% sobre os serviços.

Foco ---> Criar Componente Reutilizavel!!
Principios norteadores ---> S.O.L.I.D.

Entregaveis:
- Criar um projeto publico em repositorio (fornecer o link de acesso ao repositorio).
- Codigo fonte do componente reutilizavel no repositorio.
- No repositorio indicar como é realizada a integração/reuso do componente.
- No dia de aula apresentar funcionando o componente reutilizavel.
- Arquivo pdf  somente com o link do repositorio para posterior acesso. */  