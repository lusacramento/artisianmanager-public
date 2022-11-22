// States
export const state = () => ({
  units: [],
  unit: {
    _id: '',
    name: '',
    symbol: '',
    registerDate: '',
  },
})

// Mutations
export const mutations = {
  setUnits(state, value) {
    state.units = value
  },

  pushUnit(state, value) {
    state.units.push(value)
  },

  setUnit(state, value) {
    state.unit = value
  },

  setName(state, value) {
    state.unit.name = value
  },

  setSymbol(state, value) {
    state.unit.symbol = value
  },

  deleteUnit(state, position) {
    state.units.splice(position, 1)
  },

  clearId(state) {
    state.unit._id = null
  },
}

// Actions
export const actions = {
  // Database Operations
  async getUnits({ state, commit }) {
    if (state.units.length === 0) {
      const response = await this.$axios.$get(
        'http://localhost:8080/api/units/'
      )
      commit('setUnits', response)
    }
  },

  async deleteUnit({ state, commit }, data) {
    await this.$axios.$delete(
      `http://localhost:8080/api/units/${data.unit._id}`
    )

    commit('deleteUnit', data.position)
  },

  async send({ state, commit }) {
    if (state.unit._id === '') {
      await commit('clearId')
      await this.$axios.$post('http://localhost:8080/api/units/', state.unit)
      commit('pushUnit', state.unit)
    } else {
      const id = state.unit._id

      await commit('clearId')
      await this.$axios.$put(
        `http://localhost:8080/api/units/${id}`,
        state.unit
      )
    }
  },

  // Store operations
  setUnits({ state, commit }, value) {
    commit('setUnits', value)
  },

  setUnit({ state, commit }, value) {
    commit('setUnit', value)
  },

  setName({ state, commit }, value) {
    commit('setName', value)
  },
  setSymbol({ state, commit }, value) {
    commit('setSymbol', value)
  },
}
