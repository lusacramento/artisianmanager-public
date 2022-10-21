<template>
  <table id="table-recipe" class="table table-striped">
    <caption>
      {{
        counter
      }}
      Registro(s).
    </caption>
    <thead>
      <tr>
        <th scope="col">Nome</th>
        <th scope="col" class="text-center">Rendimento</th>
        <th scope="col" class="text-center">Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(data, index) of recipes" :key="data.id">
        <td>{{ data.name }}</td>
        <td class="text-center">{{ data.portions }} {{ data.unit }}</td>
        <td class="text-center">
          <button class="btn btn-warning m-1" @click="setRecipe(index)">
            Alterar</button
          ><button
            class="btn btn-danger m-1"
            @click="deleteRecipe(data, index)"
          >
            Excluir
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'RecipeTable',
  computed: {
    recipes() {
      return this.$store.state.recipes.recipes
    },
    counter() {
      return this.$store.state.recipes.recipes.length
    },
  },
  methods: {
    setRecipe(index) {
      this.$store.dispatch('recipes/setRecipe', index)
    },

    deleteRecipe(data, index) {
      const isDelete = confirm(
        `Deseja realmente apagar a receita "${data.name}"?`
      )

      if (isDelete) {
        this.$store.dispatch('recipes/deleteRecipe', {
          recipe: data,
          position: index,
        })
      }
    },
  },
}
</script>

<style>
#table-recipe-ingredients {
  padding: 0 !important;
  margin: 0 !important;
}
</style>
