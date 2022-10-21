<template>
  <div>
    <table class="table table-striped">
      <caption>
        {{
          count
        }}
        ingredientes.
      </caption>
      <thead>
        <tr>
          <th scope="col">Nome</th>
          <th scope="col" class="text-center">Quantidade</th>
          <th scope="col" class="text-center">Ação</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(data, index) in ingredients" :key="data.id">
          <td class="">{{ data.name }}</td>
          <td class="text-center">{{ data.quantity }} {{ data.unit }}.</td>
          <td class="text-center">
            <button
              id="buttonDelete"
              class="text-center justify-content-center btn btn-danger"
              @click="removeIngredient(index)"
            >
              Remover
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'TableIngredient',
  computed: {
    ingredients: {
      get() {
        return this.$store.state.recipes.recipe.ingredients
      },
    },
    count() {
      return this.$store.state.recipes.recipe.ingredients.length
    },
  },

  methods: {
    removeIngredient(index) {
      this.$store.dispatch('recipes/removeIngredient', index)
    },
  },
}
</script>

<style>
#buttonDelete {
  width: 70px;
  font-size: 0.8rem;
  height: 30px;

  text-align: center;
  justify-content: center;
  padding: 0;
  margin: 0;
}
</style>
