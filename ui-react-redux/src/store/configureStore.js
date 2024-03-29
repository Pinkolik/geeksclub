import {applyMiddleware, createStore} from "redux";
import thunkMiddleware from "redux-thunk";
import {createLogger} from "redux-logger";
import rootReducer from "./reducers/index";

const loggerMiddleware = createLogger();

const store = createStore(
    rootReducer,
    applyMiddleware(thunkMiddleware, loggerMiddleware)
);

export default store;
