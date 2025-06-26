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

export const onMessage = (e) => {
    console.log("Message received from main script", e);
    const { type, data, error } = e.data;
    switch (type) {
        case 'RETRY':
            if (retries < maxRetries) {
                retries++;
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
