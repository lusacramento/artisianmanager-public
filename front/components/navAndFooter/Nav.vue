<template>
  <div class="container-fluid">
    <div class="row align-items-center">
      <div class="col-12 col-lg-2">
        <div class="text-center">
          <li><nuxt-link to="/">Página Inicial</nuxt-link></li>
        </div>
      </div>
      <div class="col-12 col-lg-4">
        <div class="text-center">Cadastro</div>
        <ul class="d-flex justify-content-around">
          <li><nuxt-link to="/units">Unidades</nuxt-link></li>
          <li>
            <nuxt-link to="/raw-materials">Matérias Primas</nuxt-link>
          </li>
          <li><nuxt-link to="/recipes">Materiais Acabados</nuxt-link></li>
        </ul>
      </div>
      <div class="col-12 col-lg-3">
        <div class="text-center">Entrada</div>
        <ul class="d-flex justify-content-around">
          <li>
            <nuxt-link to="/raw-materials-inventory">Matérias Primas</nuxt-link>
          </li>
          <li><nuxt-link to="/#">Materiais Acabados</nuxt-link></li>
        </ul>
      </div>
      <div class="col-12 col-lg-3">
        <div class="text-center">Saida</div>
        <ul class="d-flex justify-content-around">
          <li><nuxt-link to="#">Produto Acabado</nuxt-link></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NavComponent',
}
</script>

<style>
ul {
  display: flex;
}
li {
  margin-inline: 10px;
  list-style: none;
}
</style>
