<template>
  <div>
    <h1>Receitas</h1>
    <FormRecipe />
    <TableRecipe />
  </div>
</template>

<script>
import FormRecipe from '~/components/recipe/FormRecipe.vue'
import TableRecipe from '~/components/recipe/TableRecipe.vue'
export default {
  name: 'RecipePage',
  components: { FormRecipe, TableRecipe },
  created() {
    this.$store.dispatch('recipes/getRecipes')
  },
}
</script>

<style></style>
