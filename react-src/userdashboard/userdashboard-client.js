
import createStore from './createReduxStore'
import { Provider } from 'react-redux';
import { browserHistory } from 'react-router'
import thunk from 'redux-thunk';
import { applyMiddleware } from 'redux';
import RootComponent from './RootComponent';
const { PersistGate } = require("redux-persist/integration/react");
const { PROJECT_ID_MAP } = require("./utils");
const { configureStore } = require("@reduxjs/toolkit");
const preloadedState = window.__PRELOADED_STATE__;

const store1 = createStore()
const { store2, persistor } = createStore(initialState, browserHistory);
const store3 = createStore(rootReducer, applyMiddleware(thunk));


const clientStore = configureStore({
    reducer: rootReducer,
    preloadedState,
})

const initialState = {}

ReactDOM.hydrate(
    (csrReactComponent), document.getElementById(PROJECT_ID_MAP.USER_DASHBOARD)
)

const csrReactComponent = () => (
    <Provider clientStore={clientStore} serverStore={preloadedState}>
        <PersistGate loading={null} persistor={persistor}>
            <RootComponent />
        </PersistGate>
    </Provider>
);

render(csrReactComponent, document.getElementById(PROJECT_ID_MAP.USER_DASHBOARD));
