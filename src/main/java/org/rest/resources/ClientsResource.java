package org.rest.resources;

import org.rest.persistence.ClientDao;
import org.rest.representations.Client;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class ClientsResource {
    private ClientDao clientDao;

    @Inject
    public ClientsResource(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Get all Client
     *
     * @return clients
     */
    @GET
    public List<Client> getAll() {
        List<Client> clients = this.clientDao.findAll();
        return clients;
    }

    /**
     * Get single Client
     *
     * @param id
     * @return client
     */
    @GET
    @Path("{id}")
    public Client getOne(@PathParam("id") long id) {
        Client client = clientDao.findOne(id);
        if (client == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            return client;
        }
    }

    /**
     * Create new Client
     *
     * @param client
     * @return new client
     */
    @POST
    public Client save(@Valid Client client) {
        return clientDao.save(client);
    }

    /**
     * Update existing Client
     *
     * @param id
     * @param client
     * @return updated client
     */
    @PUT
    @Path("{id}")
    public Client update(@PathParam("id") long id, @Valid Client client) {
        if (clientDao.findOne(id) == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            client.setId(id);
            return clientDao.save(client);
        }
    }

    /**
     * Delete client
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        Client client = clientDao.findOne(id);
        if (client == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            clientDao.delete(client);
        }
    }
}