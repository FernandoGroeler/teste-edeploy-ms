import { combineReducers } from 'redux'
import { reducer as toastrReducer } from 'react-redux-toastr'
import cidadeReducer from '../cidade/cidadeReducer'

const rootReducer = combineReducers({
    cidade: cidadeReducer,
    toastr: toastrReducer
})

export default rootReducer