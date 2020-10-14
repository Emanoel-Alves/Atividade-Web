<template>
  <div class="cadastrar">
    <h1>Cadastrar Carro</h1>
    <form style="width: 50%">
      <div class="form-group">
        <label for="nome">Nome do Carro</label>
        <input
          v-model="nome"
          type="text"
          class="form-control"
          id="nome"
          placeholder="Toyota..."
        />
      </div>
      <div class="form-group">
        <label for="marca">Marca</label>
        <input
          v-model="marca"
          type="text"
          class="form-control"
          id="marca"
          placeholder="Corola..."
        />
      </div>
      <div class="form-group">
        <label for="anoFabricacao">Ano de Fabricação</label>
        <input
          v-model="anoFabricacao"
          type="text"
          class="form-control"
          id="anoFabricacao"
          placeholder="Corola..."
        />
      </div>
      <div class="form-group">
        <label for="anoModelo">Ano do Modelo</label>
        <input
          v-model="anoModelo"
          type="text"
          class="form-control"
          id="anoModelo"
          placeholder="1999..."
        />
      </div>

      <div class="form-group">
        <label for="dataVenda">Data de Venda</label>
        <input
          v-model="dataVenda"
          type="text"
          class="form-control"
          id="dataVenda"
          placeholder="27/10/1999..."
        />
      </div>

      <button type="button" @click="postCarro()" class="btn btn-primary">
        Cadastrar Carro
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "CadastrarCarro",
  data() {
    return {
      nome: "",
      marca: "",
      dataVenda: "",
      anoFabricacao: "",
      anoModelo: "",
      carro: {},
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
      // baseURICesta: "http://localhost:8080/ichiraku-back-and/api/cestas",
    };
  },
  methods: {
    postCarro() {
      this.carro.nome = this.nome;
      this.carro.marca = this.marca;
      this.carro.anoFabricacao = this.anoFabricacao;
      this.carro.anoModelo = this.anoModelo;
      this.carro.dataVenda = this.dataVenda;

      this.$http.post(this.baseURI, this.carro).then((result) => {
        console.log(result.data);
      });
    },
  },
};
</script>

<style>
.cadastrar {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
</style>