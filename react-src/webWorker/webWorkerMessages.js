export let retries = 0;
export const maxRetries = 5;
export const delay = 1000;

export const retryOrError = (fn, err) => {
    retries++;
    if (retries < maxRetries) {
        setTimeout(fn, delay);
    } else {
        self.postMessage({
            type: "ERROR",
            data: {
                error: err.message
            }
        });
        self.close();
    }
}

export const getData = (data) => {
    retries++;
    setTimeout(() => {
        self.postMessage({ type: "GET_DATA", data: { result: "Sample data for " + data } });
    }, delay);
}

export const onMessage = (e) => {
    const { type, data, error } = e.data;
    switch (type) {
        case 'INIT':
            retries = 0; // Reset retries on initialization
            self.postMessage({ type: "READY" });
            break;
        case 'FETCH_DATA':
            if (data) {
                getData(data);
            }
            break;
        case 'RETRY':
            if (retries < maxRetries) {
                getData(data);
            } else {
                self.postMessage({ type: "NO_DATA", error: "Max retries exceeded" });
            }
            break;
        case 'NO_DATA':
        case 'ERROR':
            self.postMessage({ type: "DONE", data: null, error });
            self.close();
            break;
        default:
            console.warn("Unknown message type from main thread:", type);
            break;
    }
};

self.onmessage = onMessage;
