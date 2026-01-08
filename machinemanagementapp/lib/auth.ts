// JWT Token management utilities

export interface LoginResponse {
  token: string
  user: {
    id: number
    nom: string
    prenom: string
    email: string
    role: "ADMIN" | "SECRETAIRE" | "TECHNICIEN"
  }
}

const TOKEN_KEY = "auth_token"
const USER_KEY = "user"

// Get the JWT token from localStorage
export const getToken = (): string | null => {
  if (typeof window === "undefined") return null
  return localStorage.getItem(TOKEN_KEY)
}

// Store the JWT token and user data
export const setAuthData = (token: string, user: any): void => {
  localStorage.setItem(TOKEN_KEY, token)
  localStorage.setItem(USER_KEY, JSON.stringify(user))
}

// Get the current user from localStorage
export const getUser = (): any => {
  if (typeof window === "undefined") return null
  const userData = localStorage.getItem(USER_KEY)
  return userData ? JSON.parse(userData) : null
}

// Clear authentication data
export const clearAuth = (): void => {
  localStorage.removeItem(TOKEN_KEY)
  localStorage.removeItem(USER_KEY)
}

// Check if user is authenticated
export const isAuthenticated = (): boolean => {
  return !!getToken()
}
