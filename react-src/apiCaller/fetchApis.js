export const fetchApi = async (url) => {
  try {
        const resp = await fetch(url, {
          method: "GET",
          headers: {
            Authorization: `Bearer ${jwt}`,
            Accept: "application/json"
          },
        });
        if (!resp.ok) {
          console.error(`ID ${i} – ${resp.status} ${resp.statusText}`);
          continue;
        }
        const json = await resp.json();
        console.log(`ID ${i}`, json);
      } catch (err) {
        console.error(`ID ${i} –`, err);
      }
}

export const callInLoop = async (jwt) => {
  for (let i = 0; i < 100; i++) {
      const url = `https://www.google.com`;
      fetchApi(url);
  };
}
