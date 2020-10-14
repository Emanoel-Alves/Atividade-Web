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

      <div v-if="newCarro != null" style="width: 100%">
          <div
            style="
              margin-top: 20px;
              border: solid 1px;
              border-color: #111;
              padding-top: 13px;
            "
          >
            <strong>Cadastrado</strong>
            <p>
              <strong>ID: </strong> {{ newCarro.id }}
              <strong>Nome: </strong> {{ newCarro.nome }}
              <strong>Marca: </strong> {{ newCarro.marca }}
              <strong>Ano de Frabicação: </strong>
              {{ newCarro.anoFabricacao }} <strong>Ano do Modelo: </strong>
              {{ newCarro.anoModelo }} <strong>Data de Venda: </strong>
              {{ newCarro.dataVenda }}
            </p>
          </div>
        </div>
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
      newCarro: null,
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
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
        this.newCarro = result.data;
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