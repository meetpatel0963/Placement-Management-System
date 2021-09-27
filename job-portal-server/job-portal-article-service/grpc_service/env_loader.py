# In order to have multiple envs support use BaseLoader
# Take a look in dynaconf/loaders/json_loader.py
import json

def load(obj, env=None, silent=True, key=None, filename=None):
    """
    Reads and loads in to "obj" a single key or all keys from source
    :param obj: the settings instance
    :param env: settings current env (upper case) default='DEVELOPMENT'
    :param silent: if errors should raise
    :param key: if defined load a single key, else load all from `env`
    :param filename: Custom filename to load (useful for tests)
    :return: None
    """
    # Load data from your custom data source (file, database, memory etc)
    # use `obj.set(key, value)` or `obj.update(dict)` to load data
    # use `obj.find_file('filename.ext')` to find the file in search tree
    # Return nothing

    # This loader reads the .sff file // Stupid File Format
    keys = []
    values = []
    found_file = obj.find_file("env.json")
    if not found_file:
        return
    
    data = json.load(open(found_file))

    for i in data:
        obj.set(i,data[i])

    # # // PLEASE DON'T USE THIS SFF file format :)

    # data = dict(zip(keys, values))

    # if key:
    #     value = data.get(key.lower())  # sff format have lower case keys
    #     obj.set(key, value)
    # else:
    #     obj.update(data)

    # obj._loaded_files.append(found_file)
