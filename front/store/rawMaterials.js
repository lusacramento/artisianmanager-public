// States
export const state = () => ({
  rawMaterials: [],
  rawMaterial: {
    _id: '',
    name: '',
    description: '',
    unit: '',
  },
})

// Mutations
export const mutations = {
  setRawMaterials(state, value) {
    state.rawMaterials = value
  },

  pushRawMaterial(state, value) {
    state.rawMaterials.push(value)
  },

  setRawMaterial(state, value) {
    state.rawMaterial = value
  },

  setName(state, value) {
    state.rawMaterial.name = value
  },

  setDescription(state, value) {
    state.rawMaterial.description = value
  },

  setUnit(state, value) {
    state.rawMaterial.unit = value
  },

  deleteRawMaterial(state, position) {
    state.rawMaterials.splice(position, 1)
  },

  clearId(state) {
    state.rawMaterial._id = null
  },
}

// Actions
export const actions = {
  // Database Operations
  async getRawMaterials({ state, commit }) {
    if (state.rawMaterials.length === 0) {
      const response = await this.$axios.$get(
        'http://localhost:8080/api/raw-materials/'
      )
      commit('setRawMaterials', response)
    }
  },

  async send({ state, commit }) {
    if (state.rawMaterial._id === '') {
      await commit('clearId')
      await this.$axios.$post(
        'http://localhost:8080/api/raw-materials/',
        state.rawMaterial
      )
      commit('pushRawMaterial', state.rawMaterial)
    } else {
      const id = state.rawMaterial._id
      await commit('clearId')
      await this.$axios.$put(
        `http://localhost:8080/api/raw-materials/${id}`,
        state.rawMaterial
      )
    }
  },

  async deleteRawMaterial({ state, commit }, data) {
    await this.$axios.$delete(
      `http://localhost:8080/api/raw-materials/${data.rawMaterial._id}`
    )

    commit('deleteRawMaterial', data.position)
  },

  setRawMaterial({ state, commit }, value) {
    commit('setRawMaterial', value)
  },

  setName({ state, commit }, value) {
    commit('setName', value)
  },

  setDescription({ state, commit }, value) {
    commit('setDescription', value)
  },

  setUnit({ state, commit }, value) {
    commit('setUnit', value)
  },
}
