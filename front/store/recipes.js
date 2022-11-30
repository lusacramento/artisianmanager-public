// States
export const state = () => ({
  recipes: [],
  recipe: {
    _id: '',
    name: '',
    time: '',
    instructions: '',
    portions: '',
    unit: '',
    ingredients: [],
  },
})

// Mutations
export const mutations = {
  setRecipes(state, value) {
    state.recipes = value
  },

  setRecipe(state, value) {
    state.recipe = state.recipes[value]
  },

  setName(state, value) {
    state.recipe.name = value
  },

  setInstructions(state, value) {
    state.recipe.instructions = value
  },

  setPortions(state, value) {
    state.recipe.portions = value
  },

  setUnit(state, value) {
    state.recipe.unit = value
  },

  setTime(state, value) {
    state.recipe.time = value
  },

  insertIngredient(state, value) {
    state.recipe.ingredients.push(value)
  },

  removeIngredient(state, position) {
    state.recipe.ingredients.splice(position, 1)
  },

  setIngredientName(state, value) {
    state.ingredient.name = value
  },

  setIngredientQuantity(state, value) {
    state.ingredient.quantity = value
  },

  deleteRecipe(state, position) {
    state.recipes.splice(position, 1)
  },

  clearId(state) {
    state.recipe._id = null
  },
}

// Actions
export const actions = {
  async getRecipes({ state, commit }) {
    const response = await this.$axios.$get(
      'http://localhost:8080/api/recipes/'
    )
    commit('setRecipes', response)
  },

  setRecipe({ state, commit }, value) {
    commit('setRecipe', value)
  },

  setName({ state, commit }, value) {
    commit('setName', value)
  },

  setInstructions({ state, commit }, value) {
    commit('setInstructions', value)
  },

  setPortions({ state, commit }, value) {
    commit('setPortions', value)
  },

  setUnit({ state, commit }, value) {
    commit('setUnit', value)
  },

  setTime({ state, commit }, value) {
    commit('setTime', value)
  },

  insertIngredient({ state, commit }, value) {
    function isElement(element) {
      return element._id === value._id
    }
    state.recipe.ingredients.find(isElement)
      ? alert(`"${value.name}" já existe na lista!`)
      : commit('insertIngredient', value)
  },

  removeIngredient({ state, commit }, value) {
    commit('removeIngredient', value)
  },

  async send({ state, commit }) {
    if (state.recipe._id === '') {
      await commit('clearId')
      await this.$axios.$post(
        'http://localhost:8080/api/recipes/',
        state.recipe
      )
      commit('pushRecipe', state.recipe)
    } else {
      const id = state.recipe._id
      await commit('clearId')
      await this.$axios.$put(
        `http://localhost:8080/api/recipes/${id}`,
        state.recipe
      )
    }
  },

  async deleteRecipe({ state, commit }, data) {
    const isDeleted = await this.$axios.$delete(
      `http://localhost:8080/api/recipes/${data.recipe._id}`
    )
    isDeleted
      ? commit('deleteRecipe', data.position)
      : alert('Erro ao apagar dado')
  },

  setIngredientName({ state, commit }, value) {
    commit('setIngredientName', value)
  },

  setIngredientQuantity({ state, commit }, value) {
    commit('setIngredientQuantity', value)
  },
}
