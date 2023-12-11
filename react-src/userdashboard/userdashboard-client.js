
const { PersistGate } = require("redux-persist/integration/react");
const { PROJECT_ID_MAP } = require("./utils");
const { configureStore } = require("@reduxjs/toolkit");
const { RouterProvider } = require("react-router-dom");
const preloadedState = window.__PRELOADED_STATE__;


ReactDOM.hydrate((
    <RouterProvider store={configureStore(), }>
        <PersistGate>

        </PersistGate>
</RouterProvider>), document.getElementById(PROJECT_ID_MAP.USER_DASHBOARD))
