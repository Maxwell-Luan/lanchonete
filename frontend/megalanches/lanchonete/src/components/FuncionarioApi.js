const URL = "http://localhost:8080/funcionarios";

export async function findAll() {
  console.log("Executando findAll()");

  const requestInfo = {
    method: "GET",
    headers: {
      accept: "application/json",
      Authorization: "Bearer 12118287",
    },
  };

  const responseHttp = await fetch(URL, requestInfo);

  if (responseHttp.ok) {
    return await responseHttp.json();
  } else {
    console.log("Falha ao tentar buscar os funcionários.");
    throw new Error("Falha ao tentar buscar os funcionários.");
  }
}

export async function update(id, nome, saldo) {
  console.log(`Executando update(${id}, ${nome}, ${saldo})`);

  const requestInfo = {
    method: "PUT",
    headers: {
      accept: "application/json",
      Authorization: "Bearer 12118287",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      nome,
      saldo,
    }),
  };

  const responseHttp = await fetch(`${URL}/${id}`, requestInfo);

  if (responseHttp.ok) {
    return await responseHttp.json();
  } else if (responseHttp.status === 400) {
    const error = await responseHttp.json();
    console.log(error);
    throw new Error(JSON.stringify(error));
  } else {
    console.log("Falha ao tentar atualizar funcionário.");
    throw new Error("Falha ao tentar atualizar funcionário.");
  }
}

export async function deleteById(id) {
  console.log(`Executando deleteById(${id})`);

  const requestInfo = {
    method: "DELETE",
    headers: {
      accept: "application/json",
      Authorization: "Bearer 12118287",
    },
  };

  const responseHttp = await fetch(URL + "/" + id, requestInfo);

  if (responseHttp.ok) {
    return await responseHttp.json();
  } else {
    console.log("Falha ao tentar excluir funcionário.");
    throw new Error("Falha ao tentar excluir funcionário.");
  }
}

export async function insert(nome, saldo) {
  console.log(`Executando insert(${nome}, ${saldo})`);

  const requestInfo = {
    method: "POST",
    headers: {
      accept: "application/json",
      Authorization: "Bearer 12118287",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      nome,
      saldo,
    }),
  };

  const responseHttp = await fetch(URL, requestInfo);

  if (responseHttp.ok) {
    return await responseHttp.json();
  } else if (responseHttp.status === 400) {
    const error = await responseHttp.json();
    console.log(error);
    throw new Error(JSON.stringify(error));
  } else {
    console.log("Falha ao tentar inserir funcionário.");
    throw new Error("Falha ao tentar inserir funcionário.");
  }
}
