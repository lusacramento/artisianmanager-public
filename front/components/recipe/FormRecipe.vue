<template>
  <form action="" method="post">
    <div class="row">
      <div class="col-12 col-lg-6">
        <div class="row">
          <div class="col-12 col-lg-9">
            <div class="mb-3">
              <label for="recipe-name" class="form-label">Nome</label>
              <input
                id="recipe-name"
                v-model="name"
                type="text"
                class="form-control"
              />
            </div>
          </div>
          <div class="col-12 col-lg-3">
            <div class="mb-3">
              <label for="recipe-time" class="form-label"
                >Tempo de Preparo</label
              >
              <input
                id="recipe-time"
                v-model="time"
                type="number"
                class="form-control"
              />
            </div>
          </div>
        </div>
        <TableIngredients />
        <Ingredients />
      </div>
      <div class="col-12 col-lg-6">
        <div class="mb-3">
          <label for="recipe-instructions" class="form-label"
            >Modo de fazer</label
          >
          <textarea
            id="recipe-instructions"
            v-model="instructions"
            class="form-control"
            rows="8"
          ></textarea>
        </div>
        <div class="mb-3">
          <Label for="recipe-portion" class="form-label"
            >Rendimento (porção)</Label
          >
          <input
            id="recipe-portions"
            v-model="portions"
            type="number"
            min="1"
            class="form-control"
          />
        </div>
        <SelectUnit />
      </div>
    </div>
    <div class="row mb-3 mt-3 justify-content-center text-center">
      <div class="col">
        <button type="submit" class="btn btn-primary" @click="insertRecipe">
          Enviar
        </button>
      </div>
    </div>
  </form>
</template>

<script>
import Ingredients from './Ingredients.vue'
import TableIngredients from './TableIngredients.vue'
export default {
  name: 'FormRecipe',
  components: { Ingredients, TableIngredients },
  computed: {
    name: {
      get() {
        return this.$store.state.recipes.recipe.name
      },
      set(value) {
        this.$store.dispatch('recipes/setName', value)
      },
    },
    instructions: {
      get() {
        return this.$store.state.recipes.recipe.instructions
      },
      set(value) {
        this.$store.dispatch('recipes/setInstructions', value)
      },
    },
    portions: {
      get() {
        return this.$store.state.recipes.recipe.portions
      },
      set(value) {
        this.$store.dispatch('recipes/setPortions', value)
      },
    },
    unit: {
      get() {
        return this.$store.state.recipes.recipe.unit
      },
      set(value) {
        this.$store.dispatch('recipes/setUnit', value)
      },
    },
    time: {
      get() {
        return this.$store.state.recipes.recipe.time
      },
      set(value) {
        this.$store.dispatch('recipes/setTime', value)
      },
    },
  },

  methods: {
    insertRecipe() {
      this.$store.dispatch('recipes/postRecipe')
    },
  },
}
</script>

<style></style>
