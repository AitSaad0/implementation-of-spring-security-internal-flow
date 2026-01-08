# UserDetailsService
it is the interface responsable of finding the user in the db 
it had one important method should be implemanted : 
    public UserDetails findUserByUsername(String username)
and the entity should implement UserDetails interface and that to make spring understand the entity


# SecurityConfig 
in this calss we inject userDetailsService object from the MyUserDetailsService class create 3 methods : 
- the first one is passwordEncoder : that encode the password
- securityFilterChain and it is a filter will apply on each request 
- and finally authenticationManager and it will responsable of checking if the user enter the right credential 
  by calling passwordEncoder to encode the password and getting the user from db with userDetailsService