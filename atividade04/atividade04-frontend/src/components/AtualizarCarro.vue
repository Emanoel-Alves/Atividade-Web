<template>
  <div class="atualizar">
    <h1>Atualizar</h1>
    <div class="centralizar">
      <form style="width: 100%">
        <div class="form-group">
          <label for="id">Nome do Carro</label>
          <input
            v-model="idCarro"
            type="text"
            class="form-control"
            id="id"
            placeholder="1..."
          />
        </div>
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

        <button type="button" @click="putCarro()" class="btn btn-primary">
          Atualizar Carro
        </button>
        <div v-if="carroAnterior != null" style="width: 100%">
          <div
            style="
              margin-top: 20px;
              border: solid 1px;
              border-color: #111;
              padding-top: 13px;
            "
          >
            <strong>Anterior</strong>
            <p>
              <strong>ID: </strong> {{ carroAnterior.id }}
              <strong>Nome: </strong> {{ carroAnterior.nome }}
              <strong>Marca: </strong> {{ carroAnterior.marca }}
              <strong>Ano de Frabicação: </strong>
              {{ carroAnterior.anoFabricacao }}
              <strong>Ano do Modelo: </strong> {{ carroAnterior.anoModelo }}
              <strong>Data de Venda: </strong>
              {{ carroAnterior.dataVenda }}
            </p>
          </div>
        </div>
        <div v-if="carroUpdate != null" style="width: 100%">
          <div
            style="
              margin-top: 20px;
              border: solid 1px;
              border-color: #111;
              padding-top: 13px;
            "
          >
            <strong>Atualizado</strong>
            <p>
              <strong>ID: </strong> {{ carroUpdate.id }}
              <strong>Nome: </strong> {{ carroUpdate.nome }}
              <strong>Marca: </strong> {{ carroUpdate.marca }}
              <strong>Ano de Frabicação: </strong>
              {{ carroUpdate.anoFabricacao }} <strong>Ano do Modelo: </strong>
              {{ carroUpdate.anoModelo }} <strong>Data de Venda: </strong>
              {{ carroUpdate.dataVenda }}
            </p>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "AtualizarCarro",
  data() {
    return {
      idCarro: "",
      nome: "",
      marca: "",
      dataVenda: "",
      anoFabricacao: "",
      anoModelo: "",
      carro: {},
      carroUpdate: null,
      carroAnterior: null,
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
      // baseURICesta: "http://localhost:8080/ichiraku-back-and/api/cestas",
    };
  },
  methods: {
    putCarro() {
      this.carro.id = this.idCarro;
      this.carro.nome = this.nome;
      this.carro.marca = this.marca;
      this.carro.anoFabricacao = this.anoFabricacao;
      console.log(this.anoFabricacao);
      this.carro.anoModelo = this.anoModelo;
      this.carro.dataVenda = this.dataVenda;

      this.$http.get(this.baseURI + "/" + this.idCarro).then((result) => {
        this.carroAnterior = result.data;
      });

      this.$http
        .put(this.baseURI + "/" + this.idCarro, this.carro)
        .then((result) => {
          this.carroUpdate = result.data;
          console.log(this.carroUpdate.anoFabricacao);
        });
    },
  },
};
</script>

<style scoped>
.atualizar {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.centralizar {
  width: 50%;
}
</style>