package fr.polytech.isi3.hello.controller;

import fr.polytech.isi3.hello.domain.common.DuplicateKeyException;
import fr.polytech.isi3.hello.domain.common.NotFoundException;
import fr.polytech.isi3.hello.domain.user.User;
import fr.polytech.isi3.hello.domain.user.UserService;
import fr.polytech.isi3.hello.domain.utils.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * User controller.

 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final Logger logger;

    /**
     * Constructor.
     *
     * @param userService   user service
     * @param logger        logger
     */
    public UserController(UserService userService, Logger logger) {
        this.userService = userService;
        this.logger = logger;
    }

    /**
     * Retrieve a user by username.
     *
     * @param username      the username
     * @return              user with the given username
     * @throws NotFoundException if no user is found
     */
    @GetMapping("/{username}")
    public User retrieve(@PathVariable String username
    ) throws NotFoundException {
        this.logger.log("Retrieving user %s.", username);
        return this.userService.retrieve(username)
                .orElseThrow(NotFoundException::new);
    }

    /**
     * Create a new user.
     *
     * @param user      user information
     * @return          the newly created user
     * @throws DuplicateKeyException
     *                  if a user with the same username already exists
     */
    @PostMapping
    public User create(@RequestBody User user
    ) throws DuplicateKeyException {
        this.logger.log("Creating user %s.", user.username());
        return this.userService.create(user);
    }

    @PutMapping("/{username}")
    public User update(@PathVariable String username, @RequestBody User user) throws NotFoundException {
        if(this.userService.retrieve(username).isEmpty()) {
            throw new NotFoundException();
        }
        user = user.withUsername(username);
        return this.userService.update(user);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) throws NotFoundException {
        this.userService.delete(username);
    }
}
