import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import { useState, useEffect } from "react";
import "./AddCourse.css";
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import Axios from 'axios';


const theme = createTheme();

export default function AddCourse() {
  const initialValues = { code: "", title: "", description: "" };
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const URL =`http://localhost:8080/api/v1/course/addcourse`;

  
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    setIsSubmit(true);
  };

  useEffect(() => {
    // console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(formValues);
      Axios.post(URL, formValues)
      .then(res =>console.log(res)).catch(err => console.log(err));
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.code) {
      errors.code = "CourseCode is required!";
    } else if (values.code.length < 9 || values.code.length > 9) {
      errors.code = "CourseCode must be in 9 characters!";
    } 
    if (!values.title) {
      errors.title = "CourseName is required!";
    }
    if (!values.description) {
      errors.description = "Description is required!";
    }
    return errors;
  };

  return (
    <ThemeProvider theme={theme}>
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
            <Toolbar>
                <Typography variant="h3" component="div" sx={{ flexGrow: 1 }}>
                    Add Course
                </Typography>
            </Toolbar>
            </AppBar>
        </Box>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className="msg">
            {Object.keys(formErrors).length === 0 && isSubmit ?(
            <Stack sx={{ width: '100%' }} spacing={2}>
            <Alert severity="success">Course Added successfully</Alert>
            </Stack>): (
              <pre></pre>
            )}
          </div>
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  autoComplete="SENG11234"
                  name="code"
                  required
                  fullWidth
                  id="code"
                  label="Course Code"
                  autoFocus
                  value={formValues.code}
                  onChange={handleChange}
                />
              </Grid>
              <p>{formErrors.code}</p>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="title"
                  label="Course Name"
                  name="title"
                  autoComplete="course-name"
                  value={formValues.title}
                  onChange={handleChange}
                />
              </Grid>
              <p>{formErrors.name}</p>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="description"
                  label="Description"
                  name="description"
                  autoComplete="Description"
                  value={formValues.description}
                  onChange={handleChange}
                />
              </Grid>
              <p>{formErrors.description}</p>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              ADD
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}