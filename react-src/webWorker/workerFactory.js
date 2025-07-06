export const createWebWorker = (webWorkerMsgData) => {

    const blob = new Blob([webWorkerMsgData], { type: "application/javascript" });
    const blobUrl = URL.createObjectURL(blob);
    return new Worker(blobUrl);
};

export const createWebWorkerByMeta = (pathString) => {

    const worker = new Worker(new URL(pathString, import.meta.url), {
        type: 'module'
    });

    return worker;
};

