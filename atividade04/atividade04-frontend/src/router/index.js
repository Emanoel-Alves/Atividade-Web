import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import AtualizarCarro from "../components/AtualizarCarro.vue";
import BuscarCarro from "../components/BuscarCarro.vue";
import CadastrarCarro from "../components/CadastrarCarro.vue";
import ListagemCarro from "../components/ListagemCarro.vue";
import DeletarCarro from "../components/DeletarCarro.vue";
import BuscarPorMarca from "../components/BuscarPorMarca.vue";
import BuscarPorQuantidade from "../components/BuscarPorQuantidade.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/cadastrar",
    name: "CadastrarCarro",
    component: CadastrarCarro,
  },
  {
    path: "/buscar",
    name: "BuscarCarro",
    component: BuscarCarro,
  },
  {
    path: "/atualizar",
    name: "AtualizarCarro",
    component: AtualizarCarro,
  },
  {
    path: "/listagem",
    name: "ListagemCarro",
    component: ListagemCarro,
  },
  {
    path: "/deletar",
    name: "DeletarCarro",
    component: DeletarCarro,
  },
  {
    path: "/filtrar-marca",
    name: "BuscarPorMarca",
    component: BuscarPorMarca,
  },
  {
    path: "/filtrar-quantidade",
    name: "BuscarPorQuantidade",
    component: BuscarPorQuantidade,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
