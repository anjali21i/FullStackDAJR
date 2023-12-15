import { Provider } from 'react-redux';
import RootComponent from './RootComponent';
import { BrowserRouter } from 'react-router-dom';
import { clientStore, persistor } from './Redux/store/storeConfig';
const { PersistGate } = require("redux-persist/integration/react");
const { PROJECT_ID_MAP } = require("./utils");
const preloadedState = window.__PRELOADED_STATE__;

const initialState = {

}

ReactDOM.hydrate(
    (csrReactComponent), document.getElementById(PROJECT_ID_MAP.USER_DASHBOARD)
)

const csrReactComponent = () => (
    <Provider clientStore={clientStore} serverStore={preloadedState}>
        <PersistGate loading={null} persistor={persistor}>
            <BrowserRouter>
                <RootComponent />
            </BrowserRouter>
        </PersistGate>
    </Provider>
);

render(csrReactComponent, document.getElementById(PROJECT_ID_MAP.USER_DASHBOARD));
