<template>
  <div class="buscar">
    <h1>Buscar po ID</h1>
     <div class="centralizar">
    <form style="width: 100%">
      <div class="form-group">
        <label for="id">ID do Carro</label>
        <input
          v-model="idCarro"
          type="text"
          class="form-control"
          id="id"
          placeholder="1..."
        />
      </div>
      <button type="button" @click="getCarro()" class="btn btn-primary">
        Buscar Carro
      </button>
      <div v-if="carro != null" style="width: 100%">
        <div
          style="
            margin-top: 20px;
            border: solid 1px;
            border-color: #111;
            padding-top: 13px;
          "
        >
          <p>
            <strong>ID: </strong> {{ carro.id }} <strong>Nome: </strong>
            {{ carro.nome }} <strong>Marca: </strong> {{ carro.marca }}
            <strong>Ano de Frabicação: </strong> {{ carro.anoFabricacao }}
            <strong>Ano do Modelo: </strong> {{ carro.anoModelo }}
            <strong>Data de Venda: </strong> {{ carro.dataVenda }}
          </p>
        </div>
      </div>
    </form>
  </div>
  </div>
</template>

<script>
export default {
  name: "BuscarCarro",
  data() {
    return {
      carro: null,
      idCarro: "",
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
    };
  },
  methods: {
    getCarro() {
      this.$http.get(this.baseURI + "/" + this.idCarro).then((result) => {
        this.carro = result.data;
      });
    },
  },
};
</script>

<style scoped>
.buscar {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.centralizar {
   width: 50%;
}
</style>