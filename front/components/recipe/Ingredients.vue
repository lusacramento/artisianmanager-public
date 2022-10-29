<template>
  <div class="row align-items-end">
    <div class="col-6">
      <label for="ingredient-name" class="form-label">Ingredientes</label>
      <select
        id="ingredient-name"
        v-model="ingredient"
        class="form-select select"
        name="ingredient-name"
      >
        <option value="0" selected>Escolha uma opção</option>
        <option v-for="data in rawMaterials" :key="data._id" :value="data">
          {{ data.name }}
        </option>
      </select>
    </div>
    <div class="col-2">
      <label for="ingredient-quantity" class="form-label">Quantidade</label>
      <input
        id="ingredient-quantity"
        v-model="quantity"
        type="number"
        min="1"
        class="form-control"
      />
    </div>
    <div class="col-2">
      <label for="ingredient.unit" class="form-label">Unidade</label>
      <input
        id="ingredient-unit"
        :value="ingredient.unit"
        class="form-control"
      />
    </div>
    <div class="col-2 justify-self-center text-center">
      <input
        class="btn btn-send btn-sm justify-content-center"
        type="button"
        value="Inserir"
        @click="insertIngredient()"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: 'IngredientsLayer',
  data() {
    return {
      ingredient: {
        _id: '0',
        description: null,
        name: null,
        unit: null,
      },
      quantity: '1',
    }
  },
  computed: {
    rawMaterials: {
      get() {
        return this.$store.state.rawMaterials.rawMaterials
      },
    },
  },

  created() {
    this.$store.dispatch('rawMaterials/getRawMaterials')
  },
  methods: {
    insertIngredient() {
      this.ingredient.quantity = this.quantity

      delete this.ingredient.registerDate
      delete this.ingredient.updateDate

      this.$store.dispatch('recipes/insertIngredient', this.ingredient)
    },
  },
}
</script>

<style>
#ingredient-unit {
  border: none;
}
</style>
