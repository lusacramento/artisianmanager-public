<template>
  <div class="">
    <label for="ingredient-name" class="form-label">Ingredientes</label>
    <select
      id="ingredient-name"
      v-model="ingredient"
      class="form-select"
      name="ingredient-name"
    >
      <option value="0" selected>Escolha uma opção</option>
      <option v-for="data in rawMaterials" :key="data._id" :value="data.name">
        {{ data.name }}
      </option>
    </select>
  </div>
</template>

<script>
export default {
  name: 'IngredientComponent',
  data() {
    return {
      ingredient: '0',
    }
  },
  computed: {
    rawMaterials: {
      get() {
        return this.$store.state.rawMaterials.rawMaterials
      },
    },
  },

  watch: {
    ingredient(newIngredient) {
      // eslint-disable-next-line no-console
      console.log('watch ingredient', newIngredient)
      this.$store.dispatch('recipes/setIngredientName', newIngredient)
    },
  },
}

// counter() {
//   return this.$store.state.units.units.length
// },
</script>

<style></style>
